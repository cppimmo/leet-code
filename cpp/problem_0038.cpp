class Solution {
public:
    using Freqs = std::vector<std::pair<int, int>>;
    static Freqs digitFreqs(string s) {
        Freqs freqs;
        if (s.empty()) return freqs;

        int prev = s[0] - '0'; // Set to the 1st character
        int currCount = 1; // Start the digit count at 1
        for (std::size_t i = 1; i < s.size(); ++i) {
            const int curr = (s[i] - '0'); 
            if (curr == prev)
                ++currCount; // Increment on equal digits
            else {
                freqs.emplace_back(currCount, prev);
                prev = curr; // Store the previous digit
                currCount = 1; // Reset the digit count
            }
        }

        freqs.emplace_back(currCount, prev); // Add the last digit group
        return freqs;
    }

    static std::string toInteger(const Freqs &freqs) {
        std::ostringstream oss;
        for (const auto &[k, v] : freqs) {
            oss << k << v;
        }
        return oss.str();
    }

    string countAndSay(int n) {
#if 0
        auto freqs = digitFreqs("223314444411");
        std::cout << "[";
        for (const auto &[k, v] : freqs) {
            std::cout << "[" << k << ',' << v << "] ";
        }
        std::cout << "]\n";
        std::cout << toInteger(freqs) << '\n';
#endif /* 0 */
        std::string result = "1";

        for (int i = 1; i < n; ++i) {
            const Freqs freqs = digitFreqs(result);
            result = toInteger(freqs);
        }

        return result;
    }
};
