
class Solution
{
public:
    int scoreOfString(string s)
    {
        return std::transform_reduce(
            s.begin(), std::prev(s.end()),
            std::next(s.begin()), // Start
            0, // Initial
            std::plus{},
            [](auto a, auto b) { return std::abs(a - b); }
        );
        /*int score = 0;
        for (std::size_t i = 1; i < s.size(); ++i)
        {
            std::cout << static_cast<int>(s[i - 1]) << " - " << static_cast<int>(s[i]) << '\n';
            score += std::abs(s[i - 1] - s[i]);
        }
        return score; */
    }
};

