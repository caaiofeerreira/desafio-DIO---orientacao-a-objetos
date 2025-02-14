package OrientacaoObjetosPratica.RegistroTransacoesStreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();

        List<Transacao> transacoes = new ArrayList<>();

        for (int i = 1; i <= quantidadeTransacoes; i++) {
            char tipoTransacao = scanner.next().charAt(0);
            double valorTransacao = scanner.nextDouble();

           //TODO: Criar uma nova transação e adicioná-la à lista de transações**
            Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);

            // Verifica e atualiza o saldo da conta com base no tipo de transação
            if (transacao.getTipo() == 'd') {
                saldo += valorTransacao;
            } else if (transacao.getTipo() == 's') {
                saldo -= valorTransacao;
            }
        }

        System.out.println("\nSaldo : " + saldo);
        System.out.println("\nTransacoes:");
        transacoes.stream()
                .map(transacao -> formatarTransacao(transacao))
                .toList()
                .forEach(System.out::println);

        scanner.close();
    }

    private static String formatarTransacao(Transacao transacao) {
        // **Implementação do método `formatarTransacao`**
        String tipoFormatado = transacao.getTipo() == 'D' ? "Depósito" : "Saque";
        return String.format("%c de %.1f", transacao.getTipo(), transacao.getValor()); // Mudança na formatação
    }

    static class Transacao {
        private char tipo;
        private double valor;

        public Transacao(char tipo, double valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        public char getTipo() {
            return tipo;
        }

        public double getValor() {
            return valor;
        }
    }
}