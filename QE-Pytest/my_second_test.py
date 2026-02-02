import math

def test_sqrt():
    num=25
    assert math.sqrt(num) == 5
def testsquare():
    num = 7
    assert num*num == 49




#pytest Tests/my_second_test.py
#pytest Tests/my_second_test.py -k sqrt 
#-K i for sub string if it finds sqrt it will only execute that particular one
    

