import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainApl2{
    public static void main(String[] args) {
    // Criar instâncias das árvores BST e AVL
    BST bst = new BST();
    AVL avl = new AVL();
    Scanner scanner = new Scanner(System.in);
    
    // Solicitar ao usuário o nome do arquivo de dados
    // Exemplo: "dataset.csv"
    System.out.println("Digite o nome do arquivo de dados (.csv): ");
    String nomeArquivo = scanner.nextLine();

    try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
        String line;

        // Ler cada linha do arquivo CSV
        while ((line = br.readLine()) != null) {
            // Dividir a linha pelo delimitador ","
            String[] data = line.split(",");

            // Criar uma instância de ProgramaNetflix com os dados da linha
            ProgramaNetflix programa = createProgramaNetflix(data);

            // Verificar se todos os atributos foram preenchidos antes de inserir nas árvores
            if (programa != null) {
                // Adicionar cada coluna à árvore BST
                bst.insert(programa.getId());
                // Adicionar cada coluna à árvore AVL
                avl.raiz = avl.insereNoAVL(avl.raiz, programa.getId());
            }
        }
        
        
        System.out.println("AVL em ordem");
        String AVLemOrdem = avl.inOrderTraversal().toString();
        System.out.println(AVLemOrdem);
        
        System.out.println("BST em ordem");
        String BSTpos = bst.inOrderTraversal();
        System.out.println(BSTpos);
  
        System.out.println("Passei aqui");
       
        // Agora, as árvores BST e AVL contêm os dados do arquivo CSV
        // Faça o que for necessário com as árvores

    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static ProgramaNetflix createProgramaNetflix(String[] data) {
    // Verificar se há dados suficientes para criar uma instância de ProgramaNetflix
    if (data.length >= 15) {
    	//Verificar se o id está no formato esperado (ts ou tm seguido por numeros)
    	if (!data[0].matches(".*")) {
    		return null;
    	}
    	// Verificar o formato do título (string que pode conter espaços)
        if (!data[1].matches(".*")) {
            return null;
        }
        // Verificar o formato do tipo (string que pode variar de SHOW e MOVIE)
        if (!data[2].matches("SHOW")) {
            return null;
        }
        // Verificar o formato da descrição (string que pode conter espaços e vírgulas)
        if (!data[3].matches(".*")) {
            return null;
        }
        // Verificar o formato do ano de lançamento
        if (!data[4].matches("(19|20)\\d{2}")) {
            return null;
        }
        // Verificar o formato da classificação etária (string)
        if (!data[5].matches(".*")) {
            return null;
        }
        // Verificar runtime
        if (!data[6].matches("^[-+]?\\d*\\.?\\d+$")) {
            return null;
        }
        //Verificar generos
        if (!data[7].matches(".*")) {
            return null;
        }
        //Verificar production_countries
        if (!data[8].matches(".*")) {
            return null;
        }
        //Verificar temporadas
        if (!data[9].matches("^[-+]?\\d*\\.?\\d+$")) {
            return null;
        }
        //Verificar imdb_id
        if (!data[10].matches("(tt)\\d+")) {
            return null;
        }
        //Verificar imdb_score
        if (!data[11].matches("^[-+]?\\d*\\.?\\d+$")) {
            return null;
        }
        //Verificar imdb_votes
        if (!data[12].matches("^[-+]?\\d*\\.?\\d+$")) {
            return null;
        }
        //Verificar tmdb_popularity
        if (!data[13].matches("^[-+]?\\d*\\.?\\d+$")) {
            return null;
        }
        //Verificar tmdb_score
        if (!data[14].matches("^[-+]?\\d*\\.?\\d+$")) {
            return null;
        }
        
        // Criar uma instância de ProgramaNetflix com os dados
        return new ProgramaNetflix(
                data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
                data[5], Float.parseFloat(data[6]), data[7].split(";"),
                data[8].split(";"), Float.parseFloat(data[9]), data[10],
                Float.parseFloat(data[11]), Float.parseFloat(data[12]),
                Float.parseFloat(data[13]), Float.parseFloat(data[14])
        );
    } else {
        // Se não houver dados suficientes, retornar null
            return null;
        }
    
    
    }
}
