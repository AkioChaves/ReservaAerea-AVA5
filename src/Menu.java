import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Menu {
    private static Map<String, Passageiro> passageirosRegistrados = new HashMap<>();
    private static ArrayList<Voo> voos = new ArrayList<>();
    private static Passageiro passageiroLogado = null;

    public static void exibirMenuPrincipal(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Logar com Passageiro existente");
            System.out.println("2. Registrar novo Passageiro");
            System.out.println("3. Cadastrar Voo");
            System.out.println("4. Consultar Voo específico");
            System.out.println("5. Apagar registro de Voo");
            System.out.println("6. Encerrar o programa");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    logarComoPassageiro(scanner);
                    break;
                case 2:
                    criarNovoPassageiro(scanner);
                    break;
                case 3:
                    cadastrarVoo(scanner);
                    break;
                case 4:
                    consultarVooEspecifico(scanner);
                    break;
                case 5:
                    apagarRegistroVoo(scanner);
                    break;
                case 6:
                    System.out.println("Programa encerrado.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void logarComoPassageiro(Scanner scanner) {
        System.out.println("Digite o número do documento do passageiro:");
        String numeroDocumento = scanner.nextLine();

        if (passageirosRegistrados.containsKey(numeroDocumento)) {
            passageiroLogado = passageirosRegistrados.get(numeroDocumento);
            System.out.println("Bem-vindo, " + passageiroLogado.getNome() + "!");
            exibirMenuPassageiro(scanner);
        } else {
            System.out.println("Passageiro não encontrado.");
        }
    }

    private static void criarNovoPassageiro(Scanner scanner) {
        System.out.println("Digite o nome do passageiro:");
        String nome = scanner.nextLine();

        System.out.println("Digite o número do documento do passageiro:");
        String numeroDocumento = scanner.nextLine();

        System.out.println("Digite o número do telefone do passageiro:");
        String numeroTelefone = scanner.nextLine();

        Passageiro novoPassageiro = new Passageiro(nome, numeroDocumento, numeroTelefone);
        passageirosRegistrados.put(numeroDocumento, novoPassageiro);

        System.out.println("Passageiro criado com sucesso.");
    }

    private static void cadastrarVoo(Scanner scanner) {
        System.out.println("Digite o número do voo:");
        int numeroVoo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a origem do voo:");
        String origem = scanner.nextLine();

        System.out.println("Digite o destino do voo:");
        String destino = scanner.nextLine();

        System.out.println("Digite a data do voo:");
        String data = scanner.nextLine();

        System.out.println("Digite a hora de partida do voo:");
        String horaPartida = scanner.nextLine();

        System.out.println("Digite o número total de assentos:");
        int numAssentos = scanner.nextInt();
        scanner.nextLine();

        Voo novoVoo = new Voo(numeroVoo, origem, destino, data, horaPartida, numAssentos);
        voos.add(novoVoo);

        System.out.println("Voo cadastrado com sucesso.");
    }

    private static void consultarVooEspecifico(Scanner scanner) {
        System.out.println("Digite o número do voo a ser consultado:");
        int numeroVoo = scanner.nextInt();
        scanner.nextLine();

        for (Voo voo : voos) {
            if (voo.getNumeroVoo() == numeroVoo) {
                System.out.println("Detalhes do Voo:");
                System.out.println("Número do Voo: " + voo.getNumeroVoo());
                System.out.println("Origem: " + voo.getOrigem());
                System.out.println("Destino: " + voo.getDestino());
                System.out.println("Data: " + voo.getData());
                System.out.println("Hora de Partida: " + voo.getHoraPartida());
                System.out.println("Número de Assentos: " + voo.getNumAssentos());
                System.out.println("Assentos Disponíveis: " + voo.getAssentosDisponiveis());
                return;
            }
        }

        System.out.println("Voo não encontrado.");
    }

    private static void apagarRegistroVoo(Scanner scanner) {
        System.out.println("Digite o número do voo a ser apagado:");
        int numeroVoo = scanner.nextInt();
        scanner.nextLine();

        for (Voo voo : voos) {
            if (voo.getNumeroVoo() == numeroVoo) {
                voos.remove(voo);
                System.out.println("Voo removido com sucesso.");
                return;
            }
        }

        System.out.println("Voo não encontrado.");
    }

    private static void exibirMenuPassageiro(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menu do Passageiro ===");
            System.out.println("1. Reserva de assentos em um Voo");
            System.out.println("2. Consultar Voo do Passageiro");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Sair do Login");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    reservaAssento(scanner);
                    break;
                case 2:
                    consultarVooPassageiro();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                case 4:
                    passageiroLogado = null;
                    System.out.println("Logout realizado com sucesso.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void reservaAssento(Scanner scanner) {
        System.out.println("Digite o número do voo para reservar um assento:");
        int numeroVoo = scanner.nextInt();
        scanner.nextLine();

        for (Voo voo : voos) {
            if (voo.getNumeroVoo() == numeroVoo) {
                passageiroLogado.associarVoo(voo);
                voo.reservarAssento();
                System.out.println("Assento reservado com sucesso para o passageiro: " + passageiroLogado.getNome());
                return;
            }
        }

        System.out.println("Voo não encontrado.");
    }

    private static void consultarVooPassageiro() {
        Voo vooDoPassageiro = passageiroLogado.getVoo();
        if (vooDoPassageiro != null) {
            System.out.println("Detalhes do Voo do Passageiro:");
            System.out.println("Número do Voo: " + vooDoPassageiro.getNumeroVoo());
            System.out.println("Origem: " + vooDoPassageiro.getOrigem());
            System.out.println("Destino: " + vooDoPassageiro.getDestino());
            System.out.println("Data: " + vooDoPassageiro.getData());
            System.out.println("Hora de Partida: " + vooDoPassageiro.getHoraPartida());
            System.out.println("Número de Assentos: " + vooDoPassageiro.getNumAssentos());
            System.out.println("Assentos Disponíveis: " + vooDoPassageiro.getAssentosDisponiveis());
        } else {
            System.out.println("Você não possui um voo associado no momento.");
        }
    }

    private static void cancelarReserva() {
        if (passageiroLogado.getVoo() != null) {
            passageiroLogado.desassociarVoo();
            System.out.println("Reserva cancelada com sucesso.");
        } else {
            System.out.println("Você não possui uma reserva para cancelar.");
        }
    }
}
