while True:
    p1 = input("player1: rock paper or scissor: ").lower()
    p2 = input("player1: rock paper or scissor: ").lower()
    if p1 == p2:
        print("it is a tie")
    elif((p1 == "rock" and p2 == "scissor") or (p1 == "paper" and p2 == "rock") or (p1 == "scissor" and p2 == "paper")):
        print("p1 wins")
    elif((p2 == "rock" and p1 == "scissor") or (p2 == "paper" and p1 == "rock") or (p1 == "scissor" and p1 == "paper")):
        print("p2 wins")
    else:
        print("invalid input enter rock paper scissor")
        
    play_agian=input("do you want to play again(yes/no)").lower()
    if play_agian != "yes":
        print("exit...Thanks for playing")
        break


