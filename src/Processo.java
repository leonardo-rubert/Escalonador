public class Processo implements Comparable<Processo>
{
    private int id;
    private String nome;
    private int tempo;
    private int prioridade;

    public Processo(int id, String nome, int tempo, int prioridade)
    {
        super();
        this.id = id;
        this.nome = nome;
        this.tempo = tempo;
        this.prioridade = prioridade;
    }

    @Override
    public int compareTo(Processo proc)
    {
        return this.getPrioridade() - proc.getPrioridade();
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getTempo() { return tempo; }
    public int getPrioridade() { return prioridade; }

    @Override
    public String toString()
    {
        return "Processo [id=" + id + ", nome=" + nome + ", tempo=" + tempo + ", prioridade=" + prioridade + "]";
    }

}
