package com.bignerdranch.android.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.diceroller.ui.theme.DiceTheme


/*"Modifier класс -  это класс который используется для настройки оформления и
поведения компонентов в Compose. Он предоставляет различные
методы для применения модификаций к компонентам и их дочерним элементам.

Modifier объект - это экземпляр класса Modifier, который создается с
использованием методов класса для определенных модификаций. Например,
.fillMaxSize() устанавливает размер компонента на максимально доступный,
а .wrapContentSize(Alignment.Center) настраивает компонент так, чтобы
его содержимое было обернуто и центрировано. Modifier позволяет добавлять
и настраивать внешний вид и поведение компонентов. */




/* Перекомпозиция (recomposition) - это процесс в библиотеке Jetpack Compose,
при котором Compose пересчитывает и перерисовывает только
те части пользовательского интерфейса, которые изменились.
Это является ключевой особенностью Compose и делает его
более эффективным с точки зрения производительности. */




/*Композиция (composition) в контексте Jetpack Compose означает
процесс создания пользовательского интерфейса путем
комбинирования и компоновки различных компонентов и
элементов в одно целое. В других словах, это создание
структуры и внешнего вида пользовательского
интерфейса из разных составных частей.

Итак, основное отличие между композицией
и перекомпозицией заключается в том, что
композиция относится к созданию структуры
пользовательского интерфейса, а перекомпозиция к
обновлению этой структуры при изменениях в состоянии приложения.
Перекомпозиция является более эффективным способом
управления обновлением пользовательского интерфейса.





*/




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceTheme {
                DiceRollerApp()
            }
        }
    }
}


@Preview
@Composable

//функция,отвечающая за отображение интерфейса в превью.
fun DiceRollerApp() {
    DiceWithButtonAndImage(

        /*Почему передача Modifier в виде аргумента функции имеет смысл, даже если есть значение по умолчанию?
        Объяснение заключается в том, что Compose-файлы могут подвергаться перекомпозиции,
        и при каждой перекомпозиции код внутри @Composable функции выполняется заново.
        Если бы Modifier создавался внутри блока кода без передачи его как аргумента,
        он был бы потенциально воссоздан заново при каждой перекомпозиции,
        что может привести к неэффективному использованию ресурсов.
        Поэтому передача Modifier как аргумента позволяет более эффективно управлять его созданием и использованием,
        так как значение Modifier может быть создано один раз и использоваться повторно при каждой перекомпозиции.*/
        modifier = Modifier

            /* Этот модификатор устанавливает размер текущего компонента
            на максимально доступный размер, чтобы он занял все
            доступное пространство по ширине и высоте. Это часто
            используется, чтобы компонент заполнил
            всю доступную область экрана. */
            .fillMaxSize()

            /*Этот модификатор центрирует содержимое текущего
            компонента как по вертикали,
            так и по горизонтали. Это гарантирует, что содержимое
            будет выровнено по центру экрана.*/
            .wrapContentSize(Alignment.Center)
    )

}

/*В сигнатуре метода DiceWithButtonAndImage параметр modifier
имеет значение по умолчанию Modifier = Modifier.

Это означает, что если вызывающий код не передает явно
свой собственный Modifier объект при вызове этого метода,
то будет использоваться стандартный Modifier объект.
Использование значения параметра по умолчанию предоставляет
гибкость для тех, кто вызывает этот метод. Если им нужно
настроить внешний вид и поведение элементов, содержащихся
внутри DiceWithButtonAndImage, они могут передать свой собственный
Modifier объект. В противном случае будет использоваться стандартный
Modifier, который применяется к элементам по умолчанию.

Эта практика позволяет более гибко управлять внешним видом
и поведением компонентов и делает код более читаемым и модульным.


В данном случае Modifier объект передается в функцию
DiceWithButtonAndImage() в качестве параметра, чтобы
настроить внешний вид и поведение элементов,
содержащихся внутри DiceWithButtonAndImage.""
*/
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {


    /*"Compose-функции по умолчанию не сохраняют
    состояние между перерисовками,
    что означает, что они могут сбрасывать значения.
    Однако Compose предоставляет удобный способ избежать этого
    с помощью механизма remember.

    Функция mutableStateOf()
    используется для создания переменной с изменяемым состоянием,
    которая автоматически перерисовывает Compose-интерфейс при
    изменении этой переменной.

    var result by remember { mutableStateOf(1) } -
    В этой строке кода remember используется для
    создания переменной result с изменяемым состоянием.
    Это означает, что при каждом изменении result,
    Compose будет перерисовывать интерфейс, чтобы
    отобразить новое значение result. Переменная result
    хранит текущее значение результата броска игральной
    кости и является частью состояния вашего приложения.*/
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        /*modifier = modifier - в данной строке кода значение параметра modifier
         устанавливается равным значению аргумента modifier,
         который был передан функции DiceWithButtonAndImage.
         Это означает, что внешний вид и поведение Column
         будут определяться параметром modifier,
         переданным из вызывающей функции DiceWithButtonAndImage.

         В данном случае, вызывающей функцией является функция DiceRollerApp.
         Когда в функции DiceRollerApp создается экземпляр DiceWithButtonAndImage
         и передается ей аргумент modifier, это означает, что параметр modifier
         внутри функции DiceWithButtonAndImage будет установлен равным значению,
         переданному из DiceRollerApp. Таким образом, внешний вид и поведение Column,
         которая находится внутри функции DiceWithButtonAndImage,
         будут определяться параметром modifier, переданным из DiceRollerApp.*/
        modifier = modifier,

        /*horizontalAlignment = Alignment.CenterHorizontally - это еще один параметр функции Column,
        который определяет горизонтальное выравнивание дочерних элементов внутри столбца.
        В данном случае, он устанавливает дочерние элементы так,
        чтобы они были выровнены по центру горизонтально.*/
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //создается компонент Image, который отображает изображение игральной кости.
        Image(

            /*painter - определяет, какое изображение будет отображаться.
            В данном случае, painterResource(imageResource)
            загружает изображение согласно значению imageResource,
            которое зависит от текущего значения result.*/
            painter = painterResource(imageResource),

            /*это текстовое описание изображения для доступности.
            Здесь используется result.toString(),
            чтобы предоставить описание текущего значения result.*/
            contentDescription = result.toString()
        )

        // Этот компонент Spacer используется для создания пространства
        // (расстояния) между Image и кнопкой. Modifier.height(16.dp)
        // устанавливает вертикальный отступ в 16 пикселей.
        Spacer(modifier = Modifier.height(16.dp))

        /*Когда пользователь нажимает на кнопку, выполняется код внутри
        {  },
        который генерирует случайное
        число от 1 до 6 и присваивает
        его переменной result.*/
        Button(onClick = { result = (1..6).random() }) {


            /* Получение текста из ресурсов строки с именем
            "roll". fontSize = 24.sp
            устанавливает размер шрифта текста кнопки.*/
            Text(stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}


