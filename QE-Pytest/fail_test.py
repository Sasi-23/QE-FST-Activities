import pytest

@pytest.mark.xfail
@pytest.mark.great
def test_greater():
    x = 2
    y = 5
    assert y > x 
@pytest.mark