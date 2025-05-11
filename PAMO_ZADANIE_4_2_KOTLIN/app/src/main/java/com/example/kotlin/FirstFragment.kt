package com.example.kotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import	kotlin.random.Random
import	kotlin.math.PI

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    fun	circleArea(radius:	Int):	Double	{
        return	PI	*	radius	*	radius
    }

    fun	circleAreaOneLine(radius:	Int):	Double	=	PI	*	radius	*	radius

    fun	intervalInSeconds(hours:	Int	=	0,	minutes:	Int	=	0,	seconds:	Int	=	0)	=
        ((hours	*	60)	+	minutes)	*	60	+	seconds

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        zadanie1()
        zadanie2()
        zadanie3()
        zadanie4()
        zadanie5()
        zadanie6()
        zadanie7()
        zadanie8()
        zadanie9()
        zadanie10()
        zadanie11()
        zadanie12()
        zadanie13()
    }

    private fun zadanie1() {
        /**
         * Zadanie 1 - 72 strona
         *  Complete the code to make the program print "Mary is 20 years old" to standard output:
         */
        val name = "Mary"
        val age = 20
        Log.d("Zadanie 1", "$name is $age years old")
    }

    private fun zadanie2() {
        /**
         * Zadanie 1 - 74 strona
         *  Explicitly declare the correct type for each variable:
         */
        val	a:	Int	=	1000
        val	b:	String	=	"log	message"
        val	c:	Double	=	3.14
        val	d:	Long	=	100_000_000_000_000
        val	e:	Boolean	=	false
        val	f:	Char	=	'\n'
        Log.d("Zadanie 2", "$a $b $c $d $e $f")
    }

    private fun zadanie3() {
        /**
         * Zadanie 1 - 79 strona
         *  You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there are in total
         */
        val	greenNumbers	=	listOf(1,	4,	23)
        val	redNumbers	=	listOf(17,	2)
        val	totalCount	=	greenNumbers.count()	+	redNumbers.count()
        Log.d("Zadanie 3", "$totalCount")
    }

    private fun zadanie4() {
        /**
         * Zadanie 2 - 79 strona
         *  You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program to check whether the requested protocol
         *  is supported or not (isSupported must be a Boolean value).
         */
        val	SUPPORTED	=	setOf("HTTP",	"HTTPS",	"FTP")
        val	requested	=	"smtp"
        val	isSupported	=	requested.uppercase()	in	SUPPORTED
        Log.d("Zadanie 4", "Support	for	$requested:	$isSupported")
    }

    private fun zadanie5() {
        /**
         * Zadanie 3 - 79 strona
         * Define a map that relates integer numbers from 1 to 3 to their corresponding spelling. Use this map to spell the given number.
         */
        val	number2word	=	mapOf(1	to	"one",	2	to	"two",	3	to	"three")
        val	n	=	2
        Log.d("Zadanie 5", "$n is	spelt	as	'${number2word[n]}'")
    }

    private fun zadanie6() {
        /**
         * Zadanie 1 - 82 strona
         *  Create a simple game where you win if throwing two dice results in the same number. Use if to print You win :) if the dice match or You lose :( otherwise.
         */
        val	firstResult	= Random.nextInt(6)
        val	secondResult = Random.nextInt(6)

        if	(firstResult == secondResult)
            Log.d("Zadanie 6", "You win")
        else
             Log.d("Zadanie 6", "You lose")


    }

    private fun zadanie7() {
        /**
         * Zadanie 2 - 83 strona
         *   Using a when expression, update the following program so that it prints the corresponding actions when you input the names of game console buttons.
         */
        val	button	=	"A"

        Log.d("Zadanie 7", when (button) {
            "A"	->	"Yes"
            "B"	->	"No"
            "X"	->	"Menu"
            "Y"	->	"Nothing"
            else	->	"There	is	no	such	button"
        })
    }

    private fun zadanie8() {
        /**
         * Zadanie 2 - 83 strona
         *   You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways:
         *  Use a while loop.
         *  Use a do-while loop.
         */
        var	pizzaSlices	= 0
        pizzaSlices++
        do	{
            println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
            pizzaSlices++
        }	while	(	pizzaSlices	<	8	)

        Log.d("Zadanie 8.1", "There	are	$pizzaSlices	slices	of	pizza.	Hooray!	We	have	a	whole	pizza!	:D")

        var	pizzaSlicesDo	=	0
        pizzaSlicesDo++
        do	{
            println("There's	only	$pizzaSlicesDo	slice/s	of	pizza	:(")
            pizzaSlicesDo++
        }	while	(	pizzaSlicesDo	<	8	)
        Log.d("Zadanie 8.2", "There	are	$pizzaSlicesDo	slices	of	pizza.	Hooray!	We	have	a	whole	pizza!	:D")
    }

    private fun zadanie9() {
        /**
         * Zadanie 2 - 86 strona
         *Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three with the word
         *"fizz", and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz"
         */
        for	(number	in	1..100)	{
            Log.d("Zadanie 9",
                when	{
                    number % 15 ==	0	->	"fizzbuzz"
                    number % 3	 ==	0	->	"fizz"
                    number % 5	 ==	0	->	"buzz"
                    else	->	"$number"
                }
            )
        }
    }

    private fun zadanie10() {
        /**
         * Zadanie 3 - 86 strona
            You have a list of words. Use for and if to print only the words that start with the letter l.
         */
        val	words	=	listOf("dinosaur",	"limousine",	"magazine",	"language")
        for	(w	in	words)	{
            if	(w.startsWith("l"))
                Log.d("Zadanie 10", w)
        }
    }

    private fun zadanie11() {
        /**
         * Zadanie 1 - 89 strona
        Write a function called circleArea that takes the radius of a circle in integer format as a parameter and outputs the area of that circle.
         */
        println(circleArea(2))
        Log.d("Zadanie 11", "Wykonano zadanie 11")
    }

    private fun zadanie12() {
        /**
         * Zadanie 2 - 90 strona
        Rewrite the circleArea function from the previous exercise as a single-expression function.
         */
        println(circleAreaOneLine(2))
        Log.d("Zadanie 12", "Wykonano zadanie 12")
    }
    private fun zadanie13() {
        /**
         * Zadanie 3 - 90 strona
        You have a function that translates a time interval given in hours, minutes, and seconds into seconds. In most cases, you need to pass only one or two function
        parameters while the rest are equal to 0. Improve the function and the code that calls it by using default parameter values and named arguments so that the code is
        easier to read.
         */
        println(intervalInSeconds(1,	20,	15))
        println(intervalInSeconds(minutes	=	1,	seconds	=	25))
        println(intervalInSeconds(hours	=	2))
        println(intervalInSeconds(minutes	=	10))
        println(intervalInSeconds(hours	=	1,	seconds	=	1))
        Log.d("Zadanie 13", "Wykonano zadanie 13")
    }
}
