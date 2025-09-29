import java.util.ArrayList;
import java.util.Scanner;

// Classe Reserva
class Reserva {
    private String nome;
    private String data;
    private String hora;

    public Reserva(String nome, String data, String hora) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Nome='" + nome + '\'' +
                ", Data='" + data + '\'' +
                ", Hora='" + hora + '\'' +
                '}';
    }
}

// Classe principal Agenda
public class agenda {
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Menu Agenda ---");
            System.out.println("1. Incluir nova reserva");
            System.out.println("2. Alterar reserva");
            System.out.println("3. Excluir reserva");
            System.out.println("4. Consultar reserva");
            System.out.println("5. Listar todas as reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    incluirReserva();
                    break;
                case 2:
                    alterarReserva();
                    break;
                case 3:
                    excluirReserva();
                    break;
                case 4:
                    consultarReserva();
                    break;
                case 5:
                    listarReservas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirReserva() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Hora (hh:mm): ");
        String hora = scanner.nextLine();
        reservas.add(new Reserva(nome, data, hora));
        System.out.println("Reserva incluída com sucesso!");
    }

    private static void alterarReserva() {
        System.out.print("Informe o nome da reserva a alterar: ");
        String nomeBusca = scanner.nextLine();
        Reserva reserva = buscarReservaPorNome(nomeBusca);
        if (reserva != null) {
            System.out.print("Novo nome: ");
            reserva.setNome(scanner.nextLine());
            System.out.print("Nova data (dd/mm/aaaa): ");
            reserva.setData(scanner.nextLine());
            System.out.print("Nova hora (hh:mm): ");
            reserva.setHora(scanner.nextLine());
            System.out.println("Reserva alterada com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    private static void excluirReserva() {
        System.out.print("Informe o nome da reserva a excluir: ");
        String nomeBusca = scanner.nextLine();
        Reserva reserva = buscarReservaPorNome(nomeBusca);
        if (reserva != null) {
            reservas.remove(reserva);
            System.out.println("Reserva excluída com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    private static void consultarReserva() {
        System.out.println("Consultar por: 1-Nome 2-Data 3-Hora");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        boolean encontrada = false;
        switch (tipo) {
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                for (Reserva r : reservas) {
                    if (r.getNome().equalsIgnoreCase(nome)) {
                        System.out.println(r);
                        encontrada = true;
                    }
                }
                break;
            case 2:
                System.out.print("Data (dd/mm/aaaa): ");
                String data = scanner.nextLine();
                for (Reserva r : reservas) {
                    if (r.getData().equals(data)) {
                        System.out.println(r);
                        encontrada = true;
                    }
                }
                break;
            case 3:
                System.out.print("Hora (hh:mm): ");
                String hora = scanner.nextLine();
                for (Reserva r : reservas) {
                    if (r.getHora().equals(hora)) {
                        System.out.println(r);
                        encontrada = true;
                    }
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
        if (!encontrada) {
            System.out.println("Nenhuma reserva encontrada.");
        }
    }

    private static void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
        } else {
            System.out.println("--- Reservas ---");
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

    private static Reserva buscarReservaPorNome(String nome) {
        for (Reserva r : reservas) {
            if (r.getNome().equalsIgnoreCase(nome)) {
                return r;
            }
        }
        return null;
    }
}