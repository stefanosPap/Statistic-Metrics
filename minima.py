def asc_minima(arr, length, minima = []):
    if not arr:
        return minima
    if len(arr) == 1:
        minima.append(arr[0])
        return minima

    min_index = 0
    min_index = arr.index(min(arr))
    while True:
        if min(arr) in arr[min_index + 1:length]:
            last_min = arr[min_index + 1:length].index(min(arr))
            min_index = min_index + last_min + 1
        else:
            break 
        
    minima.append(min(arr))
    minima = asc_minima(arr[min_index + 1:length], length, minima)
    return minima

def asc_minima_shift(previous_window, new_element, previous_minima):
    if previous_window[0] == previous_minima[0]:
        previous_minima.pop(0)
    while previous_minima[len(previous_minima) - 1] > new_element:
        previous_minima.pop(len(previous_minima)-1)
        if len(previous_minima) == 0:
            break 
    
    previous_minima.append(new_element)
    return previous_minima

window = [1,3,3,2,5,8,7,8,9] 
minima = asc_minima(window, len(window))
minima2 = minima.copy()
result = asc_minima_shift(window, 0, minima)
print(minima2)
print(result)