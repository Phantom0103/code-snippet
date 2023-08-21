#coding: utf-8

import sys
import tiktoken

def main():
    content = sys.argv[1]
    model_name = sys.argv[2]
    encoding = tiktoken.encoding_for_model(model_name)
    tokens_num = len(encoding.encode(content))
    print(tokens_num)

if __name__ == "__main__":
    main()