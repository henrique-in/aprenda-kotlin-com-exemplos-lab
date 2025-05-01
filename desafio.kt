// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val nome: String){
     override fun toString(): String {
        return nome 
    }
}

data class ConteudoEducacional(var nome: String,val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
   
    val usuariosCursando = mutableListOf<Formacao>()
   
   
   
    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
    }
    
   fun matricular(usuarios: List<Usuario>) {
       inscritos.addAll(usuarios) 
   }
   
   fun detalhesDaFormacao(){
        println("Formação: $nome")
        println("Conteúdos do curso:")
        conteudos.forEach{conteudo->
        println(conteudo.nome)
        }
        println("Alunos matriculado:")
        inscritos.forEach{usuarios-> 
        println("$usuarios")       
       }
	   
       print("Número de alunos: ")
       println(inscritos.size)
       
       println("----------------------")
   }
}

fun main() {
  
    val conteudoDados = ConteudoEducacional("Estrutura de Dados", Nivel.AVANCADO,120)
    val conteudoMobile = ConteudoEducacional("Kotlin", Nivel.AVANCADO,90)
    val conteudoUx = ConteudoEducacional("UX", Nivel.AVANCADO,90)
    val conteudoUi = ConteudoEducacional("UI", Nivel.AVANCADO,60)
    
    
    val formacaoDesign = Formacao("Design", listOf(conteudoUx,conteudoUi))
    val formacaoDados = Formacao("Sistemas de informação", listOf(conteudoDados,conteudoMobile))
    
     val usuariosComputacao = mutableListOf(
        Usuario("Henrique"),
        Usuario("Steve")
    )
    val usuariosDesign = mutableListOf(
        Usuario("Laryssa"),
        Usuario("Poliana"),
        Usuario("Mark")
    )

    
   formacaoDados.matricular(usuariosComputacao)
   formacaoDesign.matricular(usuariosDesign)
   
   
   formacaoDados.detalhesDaFormacao()

   formacaoDesign.detalhesDaFormacao()
   
   
   
    
}
