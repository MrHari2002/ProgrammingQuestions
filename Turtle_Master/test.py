text = ["1234","5678"]
text[0] = "9999"
print(text)
placeholder = ""
for i in text[0]:
    placeholder+=i
text[0] = placeholder
print(text)

number = "19"
print(int(number))