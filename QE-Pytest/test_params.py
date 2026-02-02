import pytest
import pandas as Pd 

def get_csv_data():
    df = Pd.read_csv("./test_inputs.csv")
    return list(df.itertuples(index=False,name=None))
@pytest.mark.parametrize("val,expected_output",[(1,11),(2,22),(3,33)])
def test_multiply_11(val,expected_output):
    assert 11*val == expected_output