class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty())
        {
            return { };
        }

        std::unordered_map<int, std::string> digitsToLetters;
        char ch = 'a';
        for (int i = 2; i <= 6; ++i)
        {
            char stop = ch + 3;
            for (; ch < stop; ++ch) digitsToLetters[i] += ch;
        }
        digitsToLetters[7] = "pqrs";
        digitsToLetters[8] = "tuv";
        digitsToLetters[9] = "wxyz";
        
        //for (const auto &[k, v] : digitsToLetters)
        //    std::cout << k << " " << v << '\n';

        std::vector<std::string> combos = { std::string() };
        for (const char &digit : digits)
        {
            const int num = digit - '0';
            std::vector<std::string> tempCombos;
            for (const auto &combo : combos)
            {
                for (const char ch : digitsToLetters[num])
                    tempCombos.push_back(combo + ch);
            }
            combos = std::move(tempCombos);
        }
        return combos;
    }
};
