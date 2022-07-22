//Walker Mastrangelo 		July 19th, 2022
//BIS Interview Follow-Up Questions
//Fibonacci Numbers

package main

import "fmt"

func main() {

	Fibonacci(10)

}

func Fibonacci(n int) {

	fibSlice := make([]int, n) //Initialize container
	fibSlice[0] = 0            //Initialize starting values of Fibonacci sequences
	fibSlice[1] = 1
	fmt.Printf("%d, %d", fibSlice[0], fibSlice[1])

	for i := 2; i < n; i++ {
		fibSlice[i] = fibSlice[i-2] + fibSlice[i-1] //Calculate next Fibonacci number
		fmt.Printf(", %d", fibSlice[i])
	}

	fmt.Printf("\n")

}
