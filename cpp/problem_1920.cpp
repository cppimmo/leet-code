#include <ranges>
class Solution {
public:
    vector<int> buildArray(vector<int>& nums) {
#if 0
        std::vector<int> ans(nums.size());
        for (std::size_t i = 0; i < nums.size(); ++i) {
            ans[i] = nums[nums[i]];
        }
        return ans;
#endif
        std::vector<std::size_t> indices(nums.size());
        std::iota(indices.begin(), indices.end(), 0);
        auto view = indices | std::ranges::views::transform([&](auto i) { return nums[nums[i]]; });
        return std::vector(view.begin(), view.end());
    }
};
