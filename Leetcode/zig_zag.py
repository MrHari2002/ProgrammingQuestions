def convert(s: str, num_rows: int) -> str:
    jump_number = (num_rows - 1) * 2
    row_number = 0

    if num_rows == 1:
        return s

    return_string = ""
    i = 0
    j = 0
    # iterating over the entire string
    while i != len(s):
        # first row
        if row_number == 0:
            if j < len(s):
                return_string += s[j]
            j += jump_number
            i += 1
            if j >= len(s):
                row_number += 1
                j = row_number
        elif row_number != num_rows - 1:
            # Adding the first letter
            if j < len(s):
                return_string += s[j]
            j += jump_number - 2 * row_number
            # Adding the second letter
            if j < len(s):
                return_string += s[j]
            if j >= len(s):
                row_number += 1
                j = row_number
            else:
                j += 2 * row_number
                i += 2

        else:
            if j < len(s):
                return_string += s[j]
            j += jump_number
            i += 1
            if j >= len(s):
                break

    return return_string


def convert_solution(s: str, numRows: int) -> str:
    if numRows == 1: return s

    res = ""
    for row in range(numRows):
        increment = 2 * (numRows - 1)
        for i in range(row, len(s), increment):
            res += s[i]
            if 0 < row < numRows - 1 and i + increment - 2 * row < len(s):
                res += s[i + increment - 2 * row]

    return res


# print(convert("paypalishiring", 4))
print(convert("paypalishiring", 3))
print(convert("ab", 3))

print(convert_solution("paypalishiring", 3))
