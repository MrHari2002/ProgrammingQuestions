# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')


# See PyCharm help at https://www.jetbrains.com/help/pycharm/
def length_of_longest_substring(s: str) -> int:
    max_set = set()
    m = 0
    i = 0
    j = 0
    while i < len(s):
        if s[i] not in max_set:
            max_set.add(s[i])
            i += 1
            max_set = max(max_set, m)
        else:
            max_set.remove(s[j])
            j += 1

    return m



