package exercicios;

import exercicios.base.Aula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Aula06 extends Aula {

    private final Predicate<Estudante> mulheresAprovadas =
            e -> e.getSexo() == 'F'
                    && e.getCurso() != null
                    && e.getNota() >= 6;

    public Aula06() {
        System.out.println("Mulheres aprovadas:");
        getEstudantesMulheresAprovadas().forEach(System.out::println);

        System.out.println("\nOrdenadas por curso e nota:");
        getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota().forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Aula06();
    }

  
    public List<Estudante> getEstudantesMulheresAprovadas() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .toList();
    }

  
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        Comparator.comparing((Estudante e) -> e.getCurso().getNome())
                                  .thenComparing(Estudante::getNota)
                )
                .toList();
    }

   
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        Comparator.comparing((Estudante e) -> e.getCurso().getNome()).reversed()
                                  .thenComparing(Estudante::getNota)
                )
                .toList();
    }

   
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        Comparator.comparing((Estudante e) -> e.getCurso().getNome())
                                  .thenComparing(Estudante::getNota, Comparator.reverseOrder())
                )
                .toList();
    }

    
    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(
                        Comparator.comparing((Estudante e) -> e.getCurso().getNome()).reversed()
                                  .thenComparing(Estudante::getNota, Comparator.reverseOrder())
                )
                .toList();
    }

 
    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

Implementa predicados e comparadores compostos (Aula06)
