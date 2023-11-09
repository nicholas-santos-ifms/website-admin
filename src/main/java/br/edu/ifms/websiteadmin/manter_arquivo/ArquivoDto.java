package br.edu.ifms.websiteadmin.manter_arquivo;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author santos
 *
 */
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoDto extends AdapterBaseObjectDto {

    private String tipo;
    private byte[] data;

}
