package trabalho1;

import java.io.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;


// Classe UsuarioAdmin: Abstração de um administrador para os efeitos do sistema. Extende usuario.

public class UsuarioAdmin extends Usuario {

    // Construtor.

    public UsuarioAdmin(String nome, String senha, String dataNasc, String email, boolean status) {
        super(nome, senha, dataNasc, email, status);
    }

    // Métodos de usuarioAdmin.

    // Método cadastrarCupom: Permite ao Admin cadastrar um cupom no sistema.

    public void cadastrarCupom(String codigo, double desconto) {

        Cupom cupom = new Cupom(codigo, desconto);
        Biblioteca.cupons.add(cupom);

    }

    // Método listaDados: Permite ao Admin listar o conteúdo de cada uma das AL de Biblioteca.

    public void listaDados() {

        System.out.println("Digite a opcao desejada: ");
        System.out.println("1 - Listar os livros no acervo da Biblioteca Virtual");
        System.out.println("2 - Listar os empréstimos do sistema");
        System.out.println("3 - Listar os usuários do sistema");
        System.out.println("4 - Listar os cupons do sistema");

        Scanner sc = new Scanner(System.in);

        int opcao = sc.nextInt();

        if(opcao == 1) {
            System.out.println(Biblioteca.acervo);
        } else if (opcao == 2) {
            System.out.println(Biblioteca.emprestimos);
        } else if (opcao == 3) {
            System.out.println(Biblioteca.usuarios);
        } else if (opcao == 4) {
            System.out.println(Biblioteca.cupons);
        } else {
            System.out.println("Por favor, digite uma opcao válida!");
        }
    }

    public void cadastrarLivro(String nome, String autor, int indice, int edicao, int ano, int livrosDisponiveis, double valor) {

         List<Genero> list = new ArrayList<Genero>(EnumSet.allOf(Genero.class));

         Livro livro = new Livro(nome, autor, list.get(indice), edicao, ano, livrosDisponiveis, valor);
         Biblioteca.acervo.add(livro); // Aqui está a justificativa de cadastrarLivro ser abstrato: Enquanto usuarioComum e usuarioEstudante adicionam livros em seus acervos, usuarioAdmin adiciona livros na AL acervo da Biblioteca.
         System.out.println("Livro cadastrado com sucesso!");         
    }

    public void banirUsuario(String nome) throws SistemaExcecao {

        int resultado = Gerenciador.checaUsuario(nome);

        // Se nenhuma exceção foi lançada até esse ponto, o usuário que se deseja banir existe.

        Biblioteca.usuarios.remove(Biblioteca.usuarios.get(resultado));
    }

    public void salvar(Writer writer) {
		try {
		    writer.write(this.getMensagens().toString());

		    writer.flush();

		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
    public void ler(File arquivo) {
    	try {
			FileReader arq = new FileReader(arquivo);
			BufferedReader ler = new BufferedReader(arq);
			String linha = ler.readLine();		
			while(linha != null) {
				System.out.println(linha);
				linha = ler.readLine();
			}
			ler.close();
			arq.close();	
		}catch(IOException e) {
			
		}	
	}
}
