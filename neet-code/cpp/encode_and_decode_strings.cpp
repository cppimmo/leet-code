#include <string_view>
#include <regex>
#include <iterator>
#include <cctype>

void operator<<(std::ostream &os, const std::vector<string> &vec) {
    for (const auto &elem : vec) {
        os << elem << " ";
    }
}

class Solution {
public:
    string encode(vector<string>& strs) {
        string result;

        for (std::size_t i = 0; i < strs.size(); i++) {
            const string &str = strs[i];
            // LEN:STR,
            result += std::to_string(str.length()) + ":" + str;
//#if 0            
            // Avoid placing comma for last string
            if (i != strs.size() - 1) {
                result += ',';
            }
//#endif
        }
        std::cout << result << '\n';
        return result;
        // 4:neet,4:code,4:love,3:you
    }

    vector<string> decode(string s) {
        vector<string> vec{};
        if (s.empty()) {
            return vec;
        }
#if 0
        std::size_t start = 0;
        std::string digitStr;
        int length = 0;
        std::string word;
        int j = 0;
        for (std::size_t i = 0; i < s.length(); i++) {
            char ch = s[i];

            if (std::isdigit(ch)) {
                digitStr += ch;
                vec.push_back(word);
                word = "";
            } else if (ch == ":") {
                length = std::stoi(digitStr);
                digitStr = "";
                j = i + 1;
            } else {
                if ()
            }
        }
#endif
//#if 0
        const std::regex re(",\\d+:"); // Pattern for delimeters
        const auto indexOfColon = s.find_first_of(":");
        // Move past first colon LEN:
        s = s.substr(indexOfColon + 1);
        // Copy the delimeted words into vec 
        std::copy(
            std::sregex_token_iterator(s.begin(), s.end(), re, -1),
            std::sregex_token_iterator(), // Constructs the end-of-sequence iterator
            std::back_inserter(vec) // Insert at the end of vec
        );
        //std::cout << vec << std::endl;
//#endif
        return vec;
    }
};
