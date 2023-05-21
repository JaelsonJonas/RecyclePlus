import openai

openai.api_key = "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"

messages = [{"role": "system", "content": "You are an assistant that answers questions only about recycling"}]
while True:
    user_response = input("Faça uma pergunta: ")
    messages.append({"role": "user", "content": user_response})

    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages = messages)
    resposta = response.choices[0].message.content
    print(resposta)
    messages.append({"role": "assistant", "content": resposta})