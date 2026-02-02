import math

def test_sqrt():
    num=25
    assert math.sqrt(num) == 5
def testsquare():
    num = 7
    assert num*num == 40
def testquality():
    assert 10 == 11 


#1.Tests must be in the ./Tests folder
#2.Test files should start or end with "test"
#3.Test functions should start with "test"