# Text Encoding

This document isn't specifically *for* Java, but I'm adding it for context in relation to the mention of "code points" and "code units" in the `String` section of my text book. I didn't find the textbook explanation informative enough, so I went off to do some research.

A *Unicode code unit* is a bit size used by a particular Unicode encoding, e.g. UTF-8 (8 bits), UTF-16 (16 bits) and UTF-32 (32 bits).
A *code point* is a unique integer assigned to each character. To represent one *code point* you may need several *code units*, depending on the encoding.

TODO