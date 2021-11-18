# JavaForJob

## Leetcode Editor Configure(Normal Problems)
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

## LCOF problems

Filename:
```
$!velocityTool.replace(${question.frontendQuestionId}, "剑指 Offer ", "LCOF")
```

CodeTemplate:
```
package leetcode.editor.cn;

${question.content}

import java.util.*;
import leetcode.common.*;

public class $!velocityTool.replace(${question.frontendQuestionId}, "剑指 Offer ", "LCOF"){
  public static void main(String[] args) {
       Solution solution = new $!velocityTool.replace(${question.frontendQuestionId}, "剑指 Offer ", "LCOF")().new Solution();
       int[] test = new int[]{};
       System.out.println(solution.);
  }
  
  ${question.code}
  
}
```