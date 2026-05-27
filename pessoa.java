import java.util.Scanner;

public class Pessoa {
    
    String nome;
    int idade;
    double altura, peso;
    public static Scanner jv = new Scanner(System.in);
    public static void main(String[] args) {

    Pessoa[] v = new Pessoa[10];

    int qtd = 0;

    qtd = cadastrarPessoa(v, qtd);
    qtd = cadastrarPessoa(v, qtd);

    imprimirPessoas(v, qtd);

    int maior = buscaSequencialPorIdades(v, qtd);

    System.out.println("Pessoa mais velha: " + v[maior].nome);
} 
        //Questão 1
    public static int cadastrarPessoa(pessoa[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Vetor cheio!");
            return qtd;
    }
    Pessoa p = new Pessoa();
    while (true) {
        System.out.print("Digite o nome: ");
        p.nome = jv.nextLine();
        // Se o nome NÃO existir, sai do laço
        if (!buscarNome(v, qtd, p.nome)) {
            break;
        }

        System.out.println("Nome já cadastrado!");
    }

    System.out.print("Digite a idade: ");
    p.idade = jv.nextInt();
    System.out.print("Digite o peso: ");
    p.peso = jv.nextDouble();
    System.out.print("Digite a altura: ");
    p.altura = jv.nextDouble();
    v[qtd] = p;
    return qtd + 1;
}
 // Busca de nome
    public static boolean buscarNome(pessoa[] v, int qtd, String nome) {

        for (int i = 0; i < qtd; i++) {

            if (v[i].nome.equalsIgnoreCase(nome)) {
                return true;
            }
        }

        return false;
    }

    //Questão 2
    public static void imprimirPessoas(pessoa[] v, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.println("Nome: " + v[i].nome);
            System.out.println("Idade: " + v[i].idade);
            System.out.println("Peso: " + v[i].peso);
            System.out.println("Altura: " + v[i].altura);
            double imc = calcularIMC(v, i);
            System.out.println("IMC: " + imc);
        }
    }
    public static double calcularIMC(Pessoa[] v, int i) {
        return v[i].peso / (v[i].altura * v[i].altura);
    }

    //Questão 3
    public static int maisVelhaIMCMagreza(pessoa[] v, int qtd) {
    int indice = -1;
    int maiorIdade = -1;
    for (int i = 0; i < qtd; i++) {
        double imc = v[i].peso / (v[i].altura * v[i].altura);
        if (imc < 18.5) {
            if (v[i].idade > maiorIdade) {
                maiorIdade = v[i].idade;
                indice = i;
            }
        }
    }

    return indice;
}
    //Questão 4
    public static void insertionSortPorNome(pessoa[] v, int qtd) {
    for (int i = 1; i < qtd; i++) {
        Pessoa chave = v[i];
        int j = i - 1;
        while (j >= 0 && v[j].nome.compareToIgnoreCase(chave.nome) > 0) {
            v[j + 1] = v[j];
            j -= 1;
        }
        v[j + 1] = chave;
    }
}
    //Questão 5
    public static int buscaSequencialPorIdades(pessoa[] v, int qtd){
        int maior = 0;
        for(int i = 1; i < qtd; i += 1){
            if(v[i].idade > v[maior].idade){
                maior = i;
        }
    }
}
return maior;
}
}
