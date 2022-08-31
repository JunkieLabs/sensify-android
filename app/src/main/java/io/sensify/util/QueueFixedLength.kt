package io.sensify.util

import java.util.*

/**
 * Created by Niraj on 31-08-2022.
 */
class QueueFixedLength<E>(pCount: Int, pEs: Array<E>?) {

    private val queue: Queue<E> = LinkedList()
    private var mCount = 0


    init {

        //LOGV(TAG, "QueueFixedLength: "+ pCount);
        if (pCount <= 0) {
            mCount = 0
//            return
        } else {
            mCount = pCount
            if (pEs != null) {
                if (pCount <= pEs.size) {
                    val index = pEs.size - pCount
                    for (i in index until pEs.size) {
                        queue.add(pEs[i])
                    }
                    //                return
                } else {
                    if (pCount > pEs.size) {
                        for (i in pEs.indices) {
                            queue.add(pEs[i])
                        }
                    }
                }
            }

        }


    }

    fun add(pE: E): Boolean {
        if (queue.size == mCount) queue.poll()
        return queue.offer(pE)
    }

    fun resize(newSize: Int): Boolean {
        if (newSize < 0) {
            return false
        }
        val gaps = mCount - newSize
        if (gaps > 0) {
            for (i in 0 until gaps) {
                queue.poll()
            }
        }
        mCount = newSize
        return true
    }

    fun clear() {
        queue.clear()
        mCount = 0
    }

    fun clear(pE: E) {
        queue.clear()
        if (mCount > 0) {
            for (i in 0 until mCount) {
                queue.offer(pE)
            }
        }
    }

    fun size(): Int {
        return queue.size
    }

    fun sizeMax(): Int {
        return mCount
    }

    fun toArray(data: Array<E>, aFloat: E): Array<E>? {
        val length = data.size
        //Iterator iterator = getValues();
        val size = size()
        if (length >= size) {
            for (i in 0 until length - size) {
                data[i] = aFloat
            }
            var index = length - size
            val iterator: Iterator<E> = getValues()
            while (iterator.hasNext()) {
                if (index < length) {
                    data[index] = iterator.next()
                    index++
                }
            }
        } else {
            var index = size - length
            val iterator: Iterator<E> = getValues()
            for (i in 0 until index) {
                iterator.next()
            }
            while (iterator.hasNext()) {
                if (index < length) {
                    data[index] = iterator.next()
                    index++
                }
            }
        }
        return data
    }

    fun getValues(): Iterator<E> {
        val iterator: Iterator<E> = queue.iterator()

        return object : QueueIterator<E>() {
            override fun hasNext(): Boolean {
                return iterator.hasNext()
            }

            override fun next(): E {
                return iterator.next()
            }
        }
    }

    fun getFirst(): E? {
        return queue.peek()
    }

    private abstract class QueueIterator<P> :
        MutableIterator<P> {
        override fun remove() {
            throw UnsupportedOperationException()
        }
    }


}