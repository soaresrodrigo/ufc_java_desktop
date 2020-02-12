package com.company;

import java.util.Random;

public class Luta implements ILuta{
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public Luta(Lutador desafiado, Lutador desafiante, int rounds, boolean aprovada) {
        this.desafiado = desafiado;
        this.desafiante = desafiante;
        this.rounds = rounds;
        this.aprovada = aprovada;
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    @Override
    public void marcarLuta() {
        if (this.isAprovada()){
            if (this.getDesafiado() != this.getDesafiante()){
                if (this.getDesafiado().getCategoria() == this.getDesafiante().getCategoria()){
                    this.setAprovada(true);
                }else {
                    this.setAprovada(false);
                    System.out.println("Categorias diferentes não podem lutar.");
                }
            }else {
                this.setAprovada(false);
                System.out.println("Nesse contexto um homem não pode lutar contra si mesmo.");
            }
        }

    }

    @Override
    public void lutar() {
        if (this.isAprovada()){
            int i, desafiado = 0, desafiante = 0, empate = 0;
            String vencedor;
            Random lutar = new Random(); //0 = Venceu | 1 = Perdeu | 2 = Empatou

            System.out.println("--------------------------------");
            System.out.println("Luta aprovada, vamos começar.");

            for (i = 1; i <= this.getRounds(); i++){
                switch (lutar.nextInt(3)){
                    case 0:
                        desafiante++;
                        vencedor = this.getDesafiante().getNome();
                        break;
                    case 1:
                        desafiado++;
                        vencedor = this.getDesafiado().getNome();
                        break;
                    default:
                        empate++;
                        vencedor = "Ninguêm";
                        break;
                }
                System.out.println("Round " + i + " | Vencedor: " + vencedor);
            }

            if (desafiado > desafiante && desafiado > empate ){
                this.getDesafiado().setVitorias(this.getDesafiado().getVitorias() + 1);
                this.getDesafiante().setDerrotas(this.getDesafiante().getDerrotas() + 1);
                System.out.println(this.getDesafiado().getNome() + " venceu, parabéns !!!");
            }else if (desafiante > desafiado && desafiante > empate){
                this.getDesafiante().setVitorias(this.getDesafiante().getVitorias() + 1);
                this.getDesafiado().setDerrotas(this.getDesafiado().getDerrotas() + 1);
                System.out.println(this.getDesafiante().getNome() + " venceu, parabéns !!!");
            }else{
                this.getDesafiado().setEmpates(this.getDesafiado().getEmpates() + 1);
                this.getDesafiante().setEmpates(this.getDesafiante().getEmpates() + 1);
                System.out.println("Dessa vez ninguém venceu!");
            }

            System.out.println("----------------------------------");
            System.out.println("Vamos ver como ficou a classificação!");
            this.getDesafiante().historico();
            this.getDesafiado().historico();


        }else {
            System.out.println("A luta não foi aprovada");
        }

        System.out.println("----------------------------------");

    }
}

