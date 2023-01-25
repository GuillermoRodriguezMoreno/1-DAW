package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strings"
	"time"
)

type person struct {
	personID string
	IsBold   bool
	IsWoman  bool
	IsBlond  bool
}

var correctPerson person

func main() {
	fmt.Println("Welcome to the best game")

	// read people from file and
	// choose random person
	s1 := rand.NewSource(time.Now().UnixNano())
	r1 := rand.New(s1)
	randomInt := r1.Intn(3)
	fileInputLine := readFileLine(randomInt)

	// create new person
	correctPerson = newPerson(fileInputLine)

	// while user hasn't guessed (while in java)
	hasGuessed := false
	for hasGuessed == false {
		fmt.Println("Choose question (enter numer only):\n1. Are they bold? \n2. Are they blond? \n3. Are they a woman? ")
		// listening user input
		var userClickedOn string
		fmt.Scanln(&userClickedOn)

		// answer question
		isTrue := answerToQuestion(userClickedOn)
		fmt.Println("The answer is: ", isTrue)
		// ask user if they know the answer
		fmt.Println("Guess person ID? Or Enter 0 to ask again")
		var userAnswer string
		fmt.Scanln(&userAnswer)
		if userAnswer != "0" {
			if userAnswer == correctPerson.personID {
				hasGuessed = true
			} else {
				fmt.Println("Ha ha. You suck.")
			}
		}
	}
	fmt.Println("Congrats!")

}

func answerToQuestion(property string) bool {
	switch property {
	case "1": //"Are they bold?"
		return correctPerson.IsBold
	case "2": //Are they blond?"
		return correctPerson.IsBlond
	case "3": //Are they a woman?"
		return correctPerson.IsWoman
	default:
		return false
	}
}

func newPerson(fileInput string) person {
	inputArr := strings.Split(fileInput, ",")
	randomPerson := person{
		personID: inputArr[0],
	}

	if inputArr[1] == "1" {
		randomPerson.IsBold = true
	}
	if inputArr[2] == "1" {
		randomPerson.IsBlond = true
	}
	if inputArr[3] == "1" {
		randomPerson.IsWoman = true
	}

	return randomPerson
}

func readFileLine(randomNumber int) string {
	var lines []string

	readFile, err := os.Open("people.txt")
	if err != nil {
		fmt.Println(err)
	}

	fileScanner := bufio.NewScanner(readFile)
	fileScanner.Split(bufio.ScanLines)
	for fileScanner.Scan() {
		lines = append(lines, fileScanner.Text())
	}
	readFile.Close()
	return lines[randomNumber]
}
