# Trie
Trie data structure is well-suited for implementing dictionaries. It is efficient for the following operations on words in dictionary. 
 - search
 - insert
 - delete
 - prefix search
 - lexicographic ordering of words
 
### Difference between Trie and Hashing
| Operations             | Trie                             | HashMap / HashSet              |
|------------------------|----------------------------------|--------------------------------|
| search                 | θ(word_length) in worst case     | θ(word_length) in average case |
| insert                 | θ(word_length) in worst case     | θ(word_length) in average case |
| delete                 | θ(word_length) in worst case     | θ(word_length) in average case |
| prefix search          | θ(prefix_length + output_length) | Not supported                  |
| lexicographic ordering | θ(output_length)                 | Not supported                  |

### Implementation
 - [Trie implementation using Array](https://github.com/Jigyansu-Nanda/Data-Structures-and-Algorithms/tree/master/14.%20Trie/Implementation/01.%20Trie%20implementation%20using%20Array)
 - [Trie implementation using HashMap](https://github.com/Jigyansu-Nanda/Data-Structures-and-Algorithms/tree/master/14.%20Trie/Implementation/02.%20Trie%20implementation%20using%20HashMap)
