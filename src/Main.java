// Aluno: Arthur Land Avila
// Versão: 1.0
// Data Última Atualização: 2020 09 21

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner Entrada = new Scanner(System.in);

        // Contador de ciclos principal
        int ciclo_principal = 0;

        // Variáveis temporarias
        int id = 0;
        String nome = "";
        int tempo = 0;
        int prioridade = 0;
        String palavras[];

        // Váriáveis do processo
        Processo proc, new_proc;
        Processo[] processos = new Processo[1];

        // Primeiro processo (boot)
        processos[0] = new Processo(0, "Boot", 1, 0);

        // Fila de processos em ordem natural de prioridade
        Queue<Processo> PQProcessoNatural = new PriorityQueue<>();

        System.out.println("Escalonador de processos");

        // Carrega processo(s) inicial (boot)
        for (Processo p : processos)
        {
            PQProcessoNatural.add(p);
        }

        System.out.println("Fila de processos com a ordem natural sobre prioridade");

        // Loop principal do processador
        while (true)
        {

            // Retira o processo no topo da fila
            proc = PQProcessoNatural.poll();

            if (proc == null) {
                // Se não existem mais processos, encerra o processamento
                System.out.println("Fila de processos esta vazia");
                break;
            }
            else
            {
                // Looop que executa um processo
                for (int ciclo_processo=0; ciclo_processo <= proc.getTempo(); ciclo_processo++)
                {
                    // Incrementa ciclo principal (contador)
                    ciclo_principal++;

                    System.out.println("* Ciclo principal: " + ciclo_principal);
                    System.out.println("  --> Processo em execução: " + proc);
                    System.out.println("  --> Ciclo no processo " + proc.getNome() + ": " + ciclo_processo);
                    System.out.println("  ----> Processos pendentes na fila: " + PQProcessoNatural);

                    if (!nome.equals("e"))
                    {
                        // Limpa variável nome se opção "e" (executar até o fim) não foi selecionada
                        nome = "";
                    }

                    // Pergunta sobre novo processo a ser adicionado (ou não) na file
                    while (nome.equals(""))
                    {
                        System.out.print("Informe o nome do processo ['n' para não adicionar ou 'e' para executar até o fim ou 's' para sair]: ");

                        // Input do novo processo
                        palavras = Entrada.nextLine().split(" ");
                        System.out.println(palavras[0]);
                        System.out.println(palavras[1]);
                        nome = palavras[2];
                        tempo = Integer.parseInt(palavras[5]);
                        prioridade = Integer.parseInt(palavras[8]);
                      // for (int i = 0; i < palavras.length;i++){
                         //  System.out.println(palavras[i]);
                       //}
                    }

                    if (nome.equals("e"))
                    {
                        // Continue até o fim
                        continue;
                    }

                    if (nome.equals("s"))
                    {
                        // Sair do prgrama
                        break;
                    }

                    if (!nome.equals("n"))
                    {  System.out.print("Nenhum processo novo para adicionar agora ");
                        tempo = -1;

                        while (tempo < 0 || tempo >= 100)
                        {
                            System.out.print("Informe o tempo em ciclos do processo [1:100]: ");
                            tempo = Entrada.nextInt();

                        }

                        //prioridade = -99;

                        while (prioridade < -20 || prioridade > 19)
                        {
                            System.out.print("Informe a prioridade do processo [-20:19]: ");
                            prioridade = Entrada.nextInt();
                        }

                        // Incrementa identificador de processo
                        id++;

                        // Cria no processo
                        new_proc = new Processo(id, nome, tempo, prioridade);

                        // Inclui novo processo na fila
                        PQProcessoNatural.add(new_proc);

                    }

                }

            }

        }

        System.out.println("Fim");

    }
}
