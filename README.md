# JavaForJob

## Leetcode Editor Configure
path:
> JavaForJob/leetcode/src

FileName:
```
$!velocityTool.camelCaseName(${question.titleSlug})$!velocityTool.replace(${question.frontendQuestionId}, "剑指 Offer ", "LCOF")
```
CodeTemplate:
```
package leetcode.editor.cn;

${question.content}

import java.util.*;
import leetcode.common.*;

public class $!velocityTool.camelCaseName(${question.titleSlug})${question.frontendQuestionId}{
  public static void main(String[] args) {
       Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})${question.frontendQuestionId}().new Solution();
       int[] test = new int[]{};
       System.out.println(solution.);
  }
  
  ${question.code}
  
}
```