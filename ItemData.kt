/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Programacion de Plataformas Moviles.
 * Sección: 20
 *
 * Laboratorio #3
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
     
   	val result = processList(listOf(12, "Sasd", true, "sa", "null"))
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
        if(inputList != null){
            var listas = listOf<ItemData>()
            inputList.forEach {
                if(it != null){
                   val newItem: ItemData =  when(it) {
                       is String -> {
                           ItemData(inputList.indexOf(it), it, "Cadena", "L" + it.length.toString())
                       }
                       is Int -> {
                           ItemData(
                               inputList.indexOf(it), it, "Entero", if (it % 10 == 0) {
                                   "M10"
                               } else if (it % 5 == 0) {
                                   "M5"
                               } else if (it % 2 == 0) {
                                   "M2"
                               } else {
                                   null
                               }
                           )
                       }
                       is Boolean -> {
                           ItemData(
                               inputList.indexOf(it), it, "Booleano", if (it) "Verdadero" else "Falso"
                           )
                       }
                       else -> { ItemData(inputList.indexOf(it), it, null, null)
                       }
                   }
                    listas+=(newItem)
                }
            }
            return listas
        }
        else{return null}
}