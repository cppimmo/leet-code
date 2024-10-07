#include <stddef.h>
#include <limits.h>

#define MIN(A, B) (A < B) ? A : B
#define MAX(A, B) (A > B) ? A : B

int maxArea(int* height, int heightSize)
{
    int max_area = -1;
    int shortest_height = -1;
    int *p_left = height;
    int *p_right = &height[heightSize - 1];
    //printf("%d %d\n", *p_left, *p_right);
    while (p_left < p_right) {
        ptrdiff_t width = p_right - p_left;
        shortest_height = MIN(*p_left, *p_right);
        max_area = MAX(max_area, shortest_height * width);
        //printf("%d %d %d\n", width, shortest_height, width, max_area);
        if (*p_left < *p_right)
            p_left++;
        else
            p_right--;
    }
    return max_area;
}

