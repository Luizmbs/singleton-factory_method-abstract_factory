package org.example;

import org.example.abstractfactory.AbstractFactory;
import org.example.abstractfactory.Member;
import org.example.factorymethod.Service;
import org.example.factorymethod.ServiceFactory;
import org.example.singleton.LibraryConfig;

public class Library {

    public Member cadastrarMembro(AbstractFactory fabrica, String nome) {
        return new Member(fabrica, nome);
    }

    public String realizarEmprestimo(Member membro) {
        Service servico = ServiceFactory.obterServico("Loan");
        String bibliotecario = LibraryConfig.getInstance().getUsuarioLogado();
        return servico.executar() + " para " + membro.getNome() + " (" + bibliotecario + ")";
    }

    public String realizarDevolucao(Member membro) {
        Service servico = ServiceFactory.obterServico("Return");
        String bibliotecario = LibraryConfig.getInstance().getUsuarioLogado();
        return servico.executar() + " para " + membro.getNome() + " (" + bibliotecario + ")";
    }

    public String realizarCadastro(Member membro) {
        Service servico = ServiceFactory.obterServico("Register");
        String bibliotecario = LibraryConfig.getInstance().getUsuarioLogado();
        return servico.executar() + " para " + membro.getNome() + " (" + bibliotecario + ")";
    }
}
