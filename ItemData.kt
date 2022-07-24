/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Programacion de Plataformas Moviles.
 * Sección: 20
 *
 * Laboratorio #2
 *
 * @version 1.0
 * @author Adrian Fulladolsa Palma | Carne 21592
 */

// // No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
     
   	val result = processList(listOf(10, "Enero", null, true))
    println(result)
    println(result?.size)
    
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var listas = listOf<ItemData>()   
    var index = 0
    if(inputList != null){
        inputList?.forEach {
            if(it !== null){
                var tipo: String? = ""
                var inform: String? = ""
                when(it){
                    is String ->{tipo = "Cadena"
                        inform = "L" + it.length.toString()			
                    } 
                    is Int ->{ tipo = "Entero";
                        if(it % 10 == 0){inform = "M10"}
                        else if (it % 5 == 0){inform = "M5"}
                        else if (it % 2 == 0){inform = "M2"}
                        else{inform = null}

                        }               
                    is Boolean ->{ tipo = "Booleano"
                        if(it){inform = "Verdadero"}
                        else{inform = "Falso"}

                        }
                    else ->{ tipo = null
                        inform = null}
                }
                var newItem = ItemData(
                      originalPos = index,
                      originalValue = it,
                      type = tipo,
                      info = inform
                      )
                listas+=(newItem)           
            }
            index+=1
        }
        
        return listas
    }
    else{return null}
    
  	
}