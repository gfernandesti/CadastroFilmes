/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofilmes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author patricia
 */
public class CadastroFilmes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        String menu = ("Escoha uma opção: \n\n 1- Listar um Item\n 2- "
                + "Incluir um item\n 3- Alterar um item\n 4- Excluir um item\n 5- Sair");
        int escolha = 0;
        boolean teste;
        boolean teste2 = true;

        File dir = new File("Dir");
        dir.mkdir();

        do {
            do {
                try {
                    escolha = Integer.parseInt(JOptionPane.showInputDialog(null,menu,"Cadastro de Filmes",1));
                    teste = true;
                } catch (java.lang.NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Você digitou errado digite novamente");
                    teste = false;
                }

            } while (teste == false);


            switch (escolha) {
                case 1:
                    Cadastro.ListarItem();
                    break;
                case 2:
                    Cadastro.IncluirItem();
                    break;
                case 3:
                    Cadastro.AlterarItem();
                    break;
                case 4:
                    Cadastro.ExcluirItem();
                    break;
                case 5:
                    teste2 = Cadastro.Sair(teste2);

                    break;
                default:
                    break;



            }
        } while (teste2 == true);



    }

    public static class Cadastro {

        public static void ListarItem() {

            String acumulador = "";
            String diretorio = "";


            File dira = new File("Dir");

            File[] dire = dira.listFiles();

            if (((int) dire.length != 0)) {


                for (int i = 0; i < dire.length; i++) {
                    File dir = new File(String.valueOf(dire[i]));



                    try {

                        FileReader fileReader = new FileReader(dir);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        System.out.println("\n\n\t" + String.valueOf(dire[i]));

                        while ((acumulador = bufferedReader.readLine()) != null) {


                            System.out.println(acumulador);
                        }


                        fileReader.close();
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {

                JOptionPane.showMessageDialog(null, "Não há listas. \n Inclua um novo Item");
            }

        }

        public static void IncluirItem() {



            File dir = new File("Dir");
            File[] dire = dir.listFiles();


            File arquivo = new File(dir, (dire.length) + ".txt");

            try {
                /*o tp então, Ficou assim - Cinema 1) Nome do filme 2) Gênero 3) 
                 * Duração 4) País 5) Diretor 6) Ano 7) Produtora  8-Site de informações 9) Censura 10) Distribuição*/
                arquivo.createNewFile();
                FileWriter fw = new FileWriter(arquivo, false);
                PrintWriter printWriter = new PrintWriter(fw);
                printWriter.println("Nome do Filme: " + JOptionPane.showInputDialog("Digite o Nome do Filme"));
                printWriter.println("Gênero: " + JOptionPane.showInputDialog("Digite o Gênero do Filme"));
                printWriter.println("Duração: " + JOptionPane.showInputDialog("Digite a Duração do Filme"));
                printWriter.println("País Origem: " + JOptionPane.showInputDialog("Digite o País de Origem do Filme"));
                printWriter.println("Diretor: " + JOptionPane.showInputDialog("Digite o Nome do Diretor do Filme"));
                printWriter.println("Ano: " + JOptionPane.showInputDialog("Digite o Ano do Filme"));
                printWriter.println("Produtora: " + JOptionPane.showInputDialog("Digite a Produtora do Filme"));
                printWriter.println("Site de Informações: " + JOptionPane.showInputDialog("Digite o Site de Informações do Filme"));
                printWriter.println("Censura: " + JOptionPane.showInputDialog("Digite a Idade de Censura"));
                printWriter.println("Distribuição: " + JOptionPane.showInputDialog("Digite o Nome da Distribuidora do Filme"));
                printWriter.flush();
                printWriter.close();
            } catch (IOException e) {
                System.out.println("teste");
            }



        }

        public static void AlterarItem() {
            String acumulador = "Escolha um item para Alterar \n\n";
            File diretorio = new File("Dir");
            int escolha = 0;int testando=0;
            
            String[] campos = new String[10];
            int j = 0;
            File dire[] = diretorio.listFiles();
            if (dire.length != 0) {
                for (int i = 0; i < dire.length; i++) {

                    File arquivos = new File(String.valueOf(dire[i]));
                    acumulador += i + "- " + (String.valueOf(dire[i]));
                }
                do {
                    if (testando>0) {
                        JOptionPane.showMessageDialog(null, "Você Digitou um valor inválido.");
                    }
                    escolha = Integer.parseInt(JOptionPane.showInputDialog(acumulador));
                    
                        testando++;
                   
                   
                } while (escolha < 0 || escolha >= dire.length);


                try {

                    FileReader fileReader = new FileReader(dire[escolha]);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    while ((acumulador = bufferedReader.readLine()) != null) {
                        campos[j] = acumulador;
                        j++;
                    }
                    fileReader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    /*o tp então, Ficou assim - Cinema 1) Nome do filme 2) Gênero 3) 
                     * Duração 4) País 5) Diretor 6) Ano 7) Produtora  8-Site de informações 9) Censura 10) Distribuição*/

                    FileWriter fw = new FileWriter(dire[escolha], false);
                    PrintWriter printWriter = new PrintWriter(fw);
                    int z = 0;
                    printWriter.println("Nome do Filme: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite o novo Nome do Filme"));
                    z++;
                    printWriter.println("Gênero: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite o Gênero do Filme"));
                    z++;
                    printWriter.println("Duração: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite a Duração do Filme"));
                    z++;
                    printWriter.println("País Origem: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite o País de Origem do Filme"));
                    z++;
                    printWriter.println("Diretor: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite o Nome do Diretor do Filme"));
                    z++;
                    printWriter.println("Ano: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite o Ano do Filme"));
                    z++;
                    printWriter.println("Produtora: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite a Produtora do Filme"));
                    z++;
                    printWriter.println("Site de Informações: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite o Site de Informações do Filme"));
                    z++;
                    printWriter.println("Censura: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite a Idade de Censura"));
                    z++;
                    printWriter.println("Distribuição: " + JOptionPane.showInputDialog("Antigo" + campos[z] + "\n Digite o Nome da Distribuidora do Filme"));
                    printWriter.flush();
                    printWriter.close();
                } catch (IOException e) {
                    System.out.println("teste");
                }




            } else {
                JOptionPane.showMessageDialog(null, "Não há itens. Inclua um novo item.");
            }

        }

        public static void ExcluirItem() {
            String acumulado = "\t Escolha um Item pra excluir\n";
            int escolha = 0;
            boolean teste = true;
            boolean statusRename;

            File diretorio = new File("Dir");

            File dire[] = diretorio.listFiles();
            escolha = dire.length;
            //System.out.println(escolha);

            if (escolha != 0) {
                for (int i = 0; i < dire.length; i++) {
                    acumulado += (i) + "- " + String.valueOf(dire[i]) + "\n";
                }
                while (teste = true) {
                    try {
                        escolha = Integer.parseInt(JOptionPane.showInputDialog(acumulado));
                        teste = false;
                        if (escolha < 0 || escolha >= dire.length) {
                            teste = true;
                            JOptionPane.showMessageDialog(null, "Escolha fora do Parâmetro");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Você Digitou errado");
                        teste = true;
                    }

                }

                File arq = new File(String.valueOf(dire[escolha]));
                arq.delete();
                File dira[] = diretorio.listFiles();

                for (int i = 0; i < dira.length; i++) {
                    File a = new File(String.valueOf(dira[i]));
                    File b = new File("Dir\\" + i + ".txt");
                    statusRename = a.renameTo(b);

                }


            } else {
                JOptionPane.showMessageDialog(null, "Não há itens pra excluir. \n Inclua um novo Item");
            }
        }

        public static boolean Sair(boolean teste2) {
            return (false);
        }
    }
}
    
