package br.edu.ifms.websiteadmin.exception;

public class FormFileldErrorValidationDto {

    private String campo;
    private String erro;

    public FormFileldErrorValidationDto() {
    }

    public FormFileldErrorValidationDto(Builder builder) {
        this.campo = builder.campo;
        this.erro = builder.erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public Boolean hasErro() {
        return erro != null && !erro.isBlank() && !erro.isEmpty();
    }

    public static class Builder {

        private String campo;
        private String erro;

        public Builder() {
        }

        public Builder campo(String value) {
            this.campo = value;
            return this;
        }

        public Builder erro(String value) {
            this.erro = value;
            return this;
        }

        public FormFileldErrorValidationDto build() {
            return new FormFileldErrorValidationDto(this);
        }
    }

}
