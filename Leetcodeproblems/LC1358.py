"""
LeetCode problem: 1358. Number of Substrings Containing All Three Characters
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
Time Complexity: O(n)
Space Complexity: O(1)
"""


def numberOfSubstrings(s: str) -> int:
    list = [0] * 3 # a = 0, b = 1, c = 0
    j = 0
    i = 0
    result = 0

    while (j < len(s)):
        list[ord(s[j]) - ord('a')] += 1

        while (list[0] > 0 and list[1] > 0 and list[2] > 0):
            result += (len(s) - j)
            list[ord(s[i]) - ord('a')] -= 1
            i+=1

        j += 1

    return result


def main():
    s = "abcabc"
    print(numberOfSubstrings(s))
    s = "aaacb"
    print(numberOfSubstrings(s))

if __name__ == "__main__":
    main()
