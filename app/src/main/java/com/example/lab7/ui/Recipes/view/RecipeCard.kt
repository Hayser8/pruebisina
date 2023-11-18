import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun RecipeCard(
    documentId: String,
    recipeName: String,
    recipeImage: String,
    navController: NavController
){
    Card(
        shape = RectangleShape,  // Establece la forma de la Card a RectangleShape para esquinas cuadradas
        modifier = Modifier
            .width(180.dp)  // Ancho fijo
            .height(80.dp)  // Ajusta la altura para que la imagen y el texto tengan suficiente espacio
            .padding(8.dp)
            .clickable {
                val encodedName = Uri.encode(recipeName)
                navController.navigate("recipeDetailLookup/$encodedName")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
        ) {
            // Contenedor para centrar la imagen
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),  // Ocupa todo el espacio disponible antes del texto
                contentAlignment = Alignment.Center  // Centra el contenido
            ) {
                // Imagen de la receta
                Image(
                    painter = rememberImagePainter(data = recipeImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)  // Tamaño fijo para la imagen
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )
            }

            // Nombre de la receta
            Text(
                text = recipeName,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


