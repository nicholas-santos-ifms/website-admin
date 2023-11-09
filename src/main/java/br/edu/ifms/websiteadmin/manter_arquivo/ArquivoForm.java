package br.edu.ifms.websiteadmin.manter_arquivo;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author santos
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoForm
        extends AdapterBaseObjectForm {

    private String tipo;
    private byte[] data;

}
