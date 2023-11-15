/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_codigo_chave;

import br.edu.ifms.arch.v010.service.AbstractService;
import br.edu.ifms.websiteadmin.manter_usuario.UsuarioNotFoundException;
import br.edu.ifms.websiteadmin.manter_usuario.UsuarioRepository;
import br.edu.ifms.websiteadmin.properties.RpasProperties;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicholas.santos
 */
@Service
public class KeyCodeService extends
        AbstractService<KeyCode, String, KeyCodeForm, KeyCodeRepository> {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @Autowired
//    private MailService mailService;
        
    @Autowired
    private RpasProperties props;

    @Autowired
    @Override
    public void setRepository(KeyCodeRepository repository) {
        super.repository = repository;
    }
    
    public void desativarCodigosPor(String email) {
        /**
         * Verifica se já existe um código gerado. Caso positivo, ele deve ser
         * excluído
         */
        var keyCodeList = repository.findByMail(email);
        if (!keyCodeList.isEmpty()) {
            repository.deleteByMail(email);
        }
    }
    
    /**
     * Gerar código de verifica��o. Este método é responsável por gerar o código
     *  de verifica��o. Caso já exista um código de verifica��o ativo para o
     *  e-mail informado então ele será desativado para que um novo seja criado.
     * @param email
     * @param senha
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException 
     */
    public KeyCode gerarCodigoVerificacao(String email, String senha) throws NoSuchAlgorithmException, InvalidKeyException {
        /**
         * Exclui os códigos gerados para o e-mail.
         */
        desativarCodigosPor(email);

        /**
         * Gera o código de verifica��o de 6 dígitos
         */
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        var keyCode = KeyCode.builder()
                .mail(email)
                .password(encoder.encode(senha))
                .code(KeyCode.generateCode(email))
                .createdAt(LocalDateTime.now())
                .build();

        /**
         * Grava a chave gerada para o usuário
         */
        repository.save(keyCode);
        
        return keyCode;
    }
    
    /**
     * Enviar código por e-mail. Este método tem a finalidade de enviar um e-mail
     *  de acordo com o template de e-mail 'codigo-verificacao.html'
     * @param keyCode
     * @throws URISyntaxException
     * @throws IOException 
     */
    public void enviarCodigoPorEmail(KeyCode keyCode) throws URISyntaxException, IOException {
        /**
//         * Envia um e-mail para o usuário informando sobre o código de
//         * verifica��o
//         */
//        String mailVerificatioPath = "/templates/mail/codigo-verificacao.html";
//        URL urlMail = getClass().getResource(mailVerificatioPath);
//        /**
//         * Captura o html do arquivo de e-mail Substitui as variáveis existente
//         * no texto, por exemplo: %%codigo-verificacao%% - pelo código de
//         * verifica��o gerado
//         */
//        String mailContent = FileUtility.getContentFromTextFile(urlMail)
//                .replaceAll("%%codigo-verificacao%%",
//                        keyCode.getCode());
//        /**
//         * Prepara o envio do e-mail
//         */
//        MimeMessage mime = mailService.prepareEmail(
//                "Código de verifica��o - Sistema de Avalia��o de Projetos de Pesquisa",
//                keyCode.getMail(),
//                mailContent);
//        /**
//         * Envia o e-mail
//         */
//        mailService.sendMail(mime);
    }

    /**
     * Envio de código de verifica��o. Método utilizado para enviar o código de
     * verifica��o para o advogado que está se inscrevendo no sistema
     *
     * @param form
     * @throws java.security.InvalidKeyException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */
    public void enviarCodigoVerificacaoPreInscricao(KeyCodeForm form)
            throws InvalidKeyException, NoSuchAlgorithmException,
            URISyntaxException, IOException {
        // verificar se já existe e-mail no cadastro do usuário
        var email = form.getEmail();
        var op = usuarioRepository.findByEmail(email);
        if (op.isPresent()) {
            throw new UsuarioNotFoundException(
                    "O e-mail informado já existe no sistema!");
        }

        /**
         * Gera o código de verifica��o de 6 dígitos
         */
        var keyCode = gerarCodigoVerificacao(email, form.getSenha());

        /**
         * Envia o código para o e-mail informado
         */
        enviarCodigoPorEmail(keyCode);
    }

    /**
     * Verifica��o de chave de código. Verifica se o código informado pelo
     * usuário é válido para dar sequência no cadastro do advogado.
     *
     * @param code
     * @return
     */
    public Boolean isCodigoValido(String code) {
        var op = repository.findById(code);
        if (!op.isPresent()) {
            throw new KeyCodeNotFoundException("Código inválido!");
        }
        
        if (isExpired(op.get())) {
            throw new KeyCodeNotFoundException("Código expirado!");
        }
        return true;
    }
    
    public Boolean isExpired(KeyCode keyCode) {
        return keyCode.isExpired(props.getResetPasswordTokenExpiration().toMillis());
    }

}
