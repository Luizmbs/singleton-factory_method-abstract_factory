package org.example.abstractfactory;

public class Member {

    private Contract contrato;
    private MembershipCard carteirinha;
    private String nome;

    public Member(AbstractFactory fabrica, String nome) {
        this.contrato = fabrica.createContract();
        this.carteirinha = fabrica.createCard();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String emitirContrato() {
        return this.contrato.emitir();
    }

    public String emitirCarteirinha() {
        return this.carteirinha.emitir();
    }
}
