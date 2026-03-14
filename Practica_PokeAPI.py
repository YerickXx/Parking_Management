import requests as rq;
import pprint as pp;

first_request = rq.get("https://pokeapi.co/api/v2/ability/")
view = pp.pformat(first_request.content)

for i in view:
    if "ability" == "fire":
        print(i[first_request.content])
    else:
        print(view)

