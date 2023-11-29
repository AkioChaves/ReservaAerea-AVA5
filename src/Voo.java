import java.util.ArrayList;

class Voo {
    private int numeroVoo;
    private String origem;
    private String destino;
    private String data;
    private String horaPartida;
    private int numAssentos;
    private int assentosDisponiveis;
    private ArrayList<Passageiro> passageiros;

    public Voo(int numeroVoo, String origem, String destino, String data, String horaPartida, int numAssentos) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.horaPartida = horaPartida;
        this.numAssentos = numAssentos;
        this.assentosDisponiveis = numAssentos;
        this.passageiros = new ArrayList<>();
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getData() {
        return data;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void adicionarPassageiro(Passageiro passageiro) {
        passageiros.add(passageiro);
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void reservarAssento() {
        if (assentosDisponiveis > 0) {
            assentosDisponiveis--;
            System.out.println("Assento reservado com sucesso.");
        } else {
            System.out.println("Desculpe, todos os assentos foram reservados.");
        }
    }
}
