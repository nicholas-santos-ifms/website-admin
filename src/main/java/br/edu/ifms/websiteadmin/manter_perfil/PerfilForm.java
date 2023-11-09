package br.edu.ifms.websiteadmin.manter_perfil;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author santos
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PerfilForm
        extends AdapterBaseObjectForm {

}
