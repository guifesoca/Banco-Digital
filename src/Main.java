import java.util.*;

public class Main {

	public static void main(String[] args) {
		int opcao = 0;
		int tipo = 0;
		ArrayList<Conta> listaContas = new ArrayList<>();
		do {
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("O quê deseja fazer? 1- Adicionar nova conta; 2- Fazer um saque; 3- Fazer um depósito; 4- Ver extrato; 5- Transferência; 6- Sair.");
				opcao = sc.nextInt();
			} while(opcao < 1 || opcao > 6);

			if(opcao == 1) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o nome do cliente:");
				String nome = sc.nextLine();
				Scanner tc = new Scanner(System.in);
				do {
					System.out.println("Qual o tipo de conta? 1- Corrente; 2- Poupança.");
					tipo = tc.nextInt();
				} while(tipo < 1 || tipo > 2);
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				if(tipo == 1) {
					listaContas.add(new ContaCorrente(cliente));
				}
				else {
					listaContas.add(new ContaPoupanca(cliente));
				}
			}

			if(opcao == 2) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o número da sua conta:");
				int conta = sc.nextInt();
				if(conta > listaContas.size()) {
					System.out.println("Conta inexistente!");
					continue;
				}
				listaContas.get(conta - 1).imprimirExtrato();
				Scanner ss = new Scanner(System.in);
				System.out.println("Digite o valor do saque:");
				Double saque = ss.nextDouble();
				if(saque > listaContas.get(conta - 1).saldo) {
					System.out.println("Saldo insuficiente");
					continue;
				}
				listaContas.get(conta - 1).sacar(saque);
				listaContas.get(conta - 1).imprimirExtrato();
			}

			if(opcao == 3) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o número da sua conta:");
				int conta = sc.nextInt();
				if(conta > listaContas.size()) {
					System.out.println("Conta inexistente!");
					continue;
				}
				listaContas.get(conta - 1).imprimirExtrato();
				Scanner sd = new Scanner(System.in);
				System.out.println("Digite o valor do depósito:");
				Double valor = sd.nextDouble();
				listaContas.get(conta - 1).depositar(valor);
				listaContas.get(conta - 1).imprimirExtrato();
			}

			if(opcao == 4) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o número da sua conta:");
				int conta = sc.nextInt();
				if(conta > listaContas.size()) {
					System.out.println("Conta inexistente!");
					continue;
				}
				listaContas.get(conta - 1).imprimirExtrato();
			}

			if(opcao == 5) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o número da sua conta:");
				int conta_origem = sc.nextInt();
				if(conta_origem > listaContas.size()) {
					System.out.println("Conta inexistente!");
					continue;
				}
				listaContas.get(conta_origem - 1).imprimirExtrato();
				Scanner st = new Scanner(System.in);
				System.out.println("Digite o valor da transferência:");
				Double valor = st.nextDouble();
				if(valor > listaContas.get(conta_origem - 1).saldo) {
					System.out.println("Saldo insuficiente");
					continue;
				}
				Scanner sct = new Scanner(System.in);
				System.out.println("Digite o número da conta para transferência:");
				int conta_destino = sct.nextInt();
				if(conta_destino > listaContas.size()) {
					System.out.println("Conta inexistente!");
					continue;
				}
				listaContas.get(conta_origem - 1).transferir(valor, listaContas.get(conta_destino - 1));
				listaContas.get(conta_origem - 1).imprimirExtrato();
			}

		} while(opcao != 6);
	
	}

}