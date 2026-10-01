package org.example;

import org.example.abstractfactory.IndividualFactory;
import org.example.abstractfactory.InstitutionalFactory;
import org.example.abstractfactory.Member;
import org.example.singleton.LibraryConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void deveCadastrarMembroIndividual() {
        Library library = new Library();
        Member membro = library.cadastrarMembro(new IndividualFactory(), "Marco");
        assertEquals("Marco", membro.getNome());
        assertEquals("Contrato de Associação Individual", membro.emitirContrato());
        assertEquals("Carteirinha Individual", membro.emitirCarteirinha());
    }

    @Test
    void deveCadastrarMembroInstitutional() {
        Library library = new Library();
        Member membro = library.cadastrarMembro(new InstitutionalFactory(), "Escola Modelo");
        assertEquals("Escola Modelo", membro.getNome());
        assertEquals("Contrato de Associação Institucional", membro.emitirContrato());
        assertEquals("Carteirinha Institucional", membro.emitirCarteirinha());
    }

    @Test
    void deveRealizarEmprestimoParaMembroIndividual() {
        LibraryConfig.getInstance().setUsuarioLogado("Bibliotecário 1");
        Library library = new Library();
        Member membro = library.cadastrarMembro(new IndividualFactory(), "Marco");
        assertEquals("Empréstimo concluído para Marco (Bibliotecário 1)", library.realizarEmprestimo(membro));
    }

    @Test
    void deveRealizarEmprestimoParaMembroInstitutional() {
        LibraryConfig.getInstance().setUsuarioLogado("Bibliotecário 2");
        Library library = new Library();
        Member membro = library.cadastrarMembro(new InstitutionalFactory(), "Escola Modelo");
        assertEquals("Empréstimo concluído para Escola Modelo (Bibliotecário 2)", library.realizarEmprestimo(membro));
    }

    @Test
    void deveRealizarDevolucaoParaMembroIndividual() {
        LibraryConfig.getInstance().setUsuarioLogado("Bibliotecário 3");
        Library library = new Library();
        Member membro = library.cadastrarMembro(new IndividualFactory(), "Marco");
        assertEquals("Devolução concluída para Marco (Bibliotecário 3)", library.realizarDevolucao(membro));
    }

    @Test
    void deveRealizarDevolucaoParaMembroInstitutional() {
        LibraryConfig.getInstance().setUsuarioLogado("Bibliotecário 4");
        Library library = new Library();
        Member membro = library.cadastrarMembro(new InstitutionalFactory(), "Escola Modelo");
        assertEquals("Devolução concluída para Escola Modelo (Bibliotecário 4)", library.realizarDevolucao(membro));
    }

    @Test
    void deveRealizarCadastroParaMembroIndividual() {
        LibraryConfig.getInstance().setUsuarioLogado("Bibliotecário 5");
        Library library = new Library();
        Member membro = library.cadastrarMembro(new IndividualFactory(), "Marco");
        assertEquals("Registro feito para Marco (Bibliotecário 5)", library.realizarCadastro(membro));
    }

    @Test
    void deveRealizarCadastroParaMembroInstitutional() {
        LibraryConfig.getInstance().setUsuarioLogado("Bibliotecário 6");
        Library library = new Library();
        Member membro = library.cadastrarMembro(new InstitutionalFactory(), "Escola Modelo");
        assertEquals("Registro feito para Escola Modelo (Bibliotecário 6)", library.realizarCadastro(membro));
    }
}
