class Passageiro {
    private String nome;
    private String numeroDocumento;
    private String numeroTelefone;
    private Voo voo;

    public Passageiro(String nome, String numeroDocumento, String numeroTelefone) {
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
        this.numeroTelefone = numeroTelefone;
        this.voo = null;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public Voo getVoo() {
        return voo;
    }

    public void associarVoo(Voo voo) {
        this.voo = voo;
        voo.adicionarPassageiro(this);
    }

    public void desassociarVoo() {
        if (voo != null) {
            voo.getPassageiros().remove(this);
            voo = null;
        }
    }
}
